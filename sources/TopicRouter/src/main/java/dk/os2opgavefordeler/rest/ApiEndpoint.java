package dk.os2opgavefordeler.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dk.os2opgavefordeler.assigneesearch.Assignee;
import dk.os2opgavefordeler.assigneesearch.FindAssignedForKleService;
import dk.os2opgavefordeler.auth.AuthService;
import dk.os2opgavefordeler.model.Kle;
import dk.os2opgavefordeler.model.Municipality;
import dk.os2opgavefordeler.model.api.DistributionRuleApiResultPO;
import dk.os2opgavefordeler.model.api.EmploymentApiResultPO;
import dk.os2opgavefordeler.service.*;

/**
 * This class supports the endpoints that are part of the external/programmatic API.
 *
 * @author hlo@miracle.dk
 */
@Path("/api")
@RequestScoped
public class ApiEndpoint extends Endpoint {

    @Inject
    Logger log;

    @Inject
    KleService kleService;

    @Inject
    MunicipalityService municipalityService;

    @Inject
    DistributionService distributionService;

    @Inject
    OrgUnitService orgUnitService;

    @Inject
    EmploymentService employmentService;

    @Inject
    private FindAssignedForKleService findAssignedForKleService;

    @Inject
    private AuthService authService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response lookup(@QueryParam("kle") String kleNumber, @Context UriInfo uriInfo, @Context HttpServletRequest request) {

        String email = authService.getAuthentication().getEmail();
        String token = authService.getAuthentication().getToken();

        if (token == null || token.isEmpty()) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        Optional<Municipality> municipalityMaybe = municipalityService.getMunicipalityFromToken(token);

        if (!municipalityMaybe.isPresent()) {
            return Response.status(Response.Status.UNAUTHORIZED).type(TEXT_PLAIN)
                    .entity("Did not find a municipality based on given authorization.")
		            .build();
        }

        Municipality municipality = municipalityMaybe.get();

	    if (!municipality.isActive()) {
            return Response.status(PAYMENT_REQUIRED).type(TEXT_PLAIN)
                    .entity("Your subscription is not active and therefor the api cannot be used.")
		            .build();
        }

        Optional<Kle> kleMaybe = kleService.fetchMainGroup(kleNumber, municipality.getId());

        if (!kleMaybe.isPresent()) {
            return badRequest("Did not find a Kle based on given number.");
        }

	    Kle kle = kleMaybe.get();

	    Map<String, String> parameters = new HashMap<>();

        for (Map.Entry<String, List<String>> m : uriInfo.getQueryParameters().entrySet()) {
            parameters.put(m.getKey(), m.getValue().get(0));
        }

        Assignee assignee = findAssignedForKleService.findAssignedForKle(kle, municipality, parameters);

        if (assignee == null) {
            return Response.status(Response.Status.NOT_FOUND).type(TEXT_PLAIN).entity("No one seems to be handling the given kle for municipality.").build();
        }

        EmploymentApiResultPO manager = new EmploymentApiResultPO(orgUnitService.findResponsibleManager(assignee.getOrgUnit()).orElse(null));
        EmploymentApiResultPO employee = assignee.getEmployment().map(EmploymentApiResultPO::new).orElse(null);
        DistributionRuleApiResultPO resultPO = new DistributionRuleApiResultPO(assignee.getRule(), manager, employee);

	    log.info("API endpoint called by {} for KLE: {}", email, resultPO.getKle().getNumber());

        return ok(resultPO);
    }

    @GET
    @Path("/healthcheck")
    @Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
    @NoCache
    public Response healthCheck() {
        //TODO: perform (light-weight) sanity checks.
        boolean everythingIsOk = true;

        if (everythingIsOk) {
            return ok("We get signal.");
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Somebody set up us the bomb.").build();
        }
    }
}
