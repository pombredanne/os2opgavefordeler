package dk.os2opgavefordeler.service;

import dk.os2opgavefordeler.model.Kle;

import java.io.InputStream;
import java.util.List;

public interface KleImportService {
	//TODO: replace 'Exception' with something more suitable of our own
	//TODO: have "max number of reported errors" as a parameter, fixed value, or system property? TBD.
	List<Kle> importFromXml(InputStream xml) throws Exception;
	List<Kle> importFromXml(InputStream xml, InputStream xsd) throws Exception;
}
