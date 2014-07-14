package mesquite.BTOL.BTOLDNADatabaseURLSource;

import mesquite.molec.lib.*;
import mesquite.BTOL.lib.*;
import mesquite.tol.lib.MesquiteXMLToLUtilities;

import java.util.*;

public class BTOLDNADatabaseURLSource extends DNADatabaseURLSource {

	public boolean startJob(String arguments, Object condition, boolean hiredByName) {
		return true;
	}

	public String getKeyString(int key) {
		switch (key) {
		case PRIMER_NAME:
			return BTOLRequestParameters.PRIMER_NAME;

		case SAMPLE_CODE:
			return BTOLRequestParameters.SAMPLE_CODE;

		case GENE:
			return BTOLRequestParameters.GENE;
		case TAXON:
			return BTOLRequestParameters.TAXON;
		case NAME:
			return BTOLRequestParameters.NAME;
		case EXTRACTION:
			return BTOLRequestParameters.EXTRACTION;
			
		case AUTHORIZATION_KEY:
			return BTOLRequestParameters.AUTHORIZATION_KEY;
			
		case COUNT:
			return BTOLRequestParameters.COUNT;


		}
		return "";

	}
	
	public String getElementName(int elementID) {
		switch (elementID) {
		case SEQUENCE_ELEMENT:
			return BTOLRequestParameters.SEQUENCE_ELEMENT;

		}
		return "";

	}
	
	public String getChromatogramDownloadURL(Hashtable args) {
		if (args!=null)
			args.put("service", "chromatogramdownload");
		return  getBaseURL()+getPage(CHROMATOGRAM_DOWNLOAD_SERVICE);
	}

	public boolean includeSampleCodePrefixInSampleCode() {
		return true;
	}

	public boolean needsKeyValuePairAuthorization() {
		return true;
	}

	public String getPage(int whichPage) {
		switch (whichPage) {
		case PRIMER_SERVICE:
			return "btolxml/PrimerService";
			
		case SEQUENCE_NAME_SERVICE :
			return "btolxml/SequenceNameService";

		case CONTRIBUTOR_SERVICE :
			return "btolxml/ContributorList";

		case  CHROMATOGRAM_SEARCH_SERVICE :
			return "btolxml/ChromatogramSearchService";

		case  SEQUENCE_UPLOAD_SERVICE :
		return "btolxml/SequenceUploadService";

		case  FASTA_UPLOAD_SERVICE :
			return "btolxml/FastaUpload";

		case  CHROMATOGRAM_BATCH_CREATION_SERVICE :
			return "btolxml/ChromatogramBatchCreationService";

		}
		return "";

	}

	
	public String getBaseURL() {
		return MesquiteXMLToLUtilities.getTOLPageDatabaseURL("http://btol.tolweb.org");
	}
	
	public String getKey() {
		return "archostemataarec00L";
	}


	public String getName() {
		return "BTOL DNA Database URL";
	}



}
