package dk.os2opgavefordeler.service;

import java.io.InputStream;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import dk.os2opgavefordeler.model.Kle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import dk.os2opgavefordeler.model.kle_import.KLEEmneplanKomponent;
import dk.os2opgavefordeler.model.kle_import.ObjectFactory;

public class KleImportServiceImpl implements KleImportService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<Kle> importFromXml(InputStream xml)
	throws Exception
	{
		if(xml == null) {
			throw new IllegalArgumentException("xml == null");
		}

		return internalImport(xml, null);
	}

	@Override
	public List<Kle> importFromXml(InputStream xml, InputStream xsd)
	throws Exception
	{
		if(xml == null) {
			throw new IllegalArgumentException("xml == null");
		}
		if(xsd == null) {
			throw new IllegalArgumentException("xsd == null");
		}
		return internalImport(xml, xsd);
	}



	private List<Kle> internalImport(InputStream xml, InputStream xsd)
	throws Exception
	{
		try {
			log.info("internalImport: Initializing context + unmarshaller");
			final JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			if (xsd != null) {
				log.info("internalImport: Initializing schema");
				final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				final Schema schema = sf.newSchema(new StreamSource(xsd));
				unmarshaller.setSchema(schema);
			}

			log.info("internalImport: Unmarshalling KLE XML");
			final JAXBElement<KLEEmneplanKomponent> plan =
					unmarshaller.unmarshal(new StreamSource(xml), KLEEmneplanKomponent.class);

			log.info("internalImport: Mapping to entity models");
			final List<Kle> groups = KleImportMapperImpl.mapMainGroupList(plan.getValue());
			return groups;
		}
		catch(JAXBException|SAXException ex) {
			//TODO: proper exception of our own
			throw ex;
		}
	}
}
