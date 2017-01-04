package Tools;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class TableParser {
	
    private Reader getReader(String relativePath) throws UnsupportedEncodingException {
        return new InputStreamReader(this.getClass().getResourceAsStream(relativePath), "UTF-8");

    }
	
    public List<String[]> createTable(String csvFileName){
    	CsvParserSettings settings = new CsvParserSettings();
    	//the file used in the example uses '\n' as the line separator sequence.
    	//the line separator sequence is defined here to ensure systems such as MacOS and Windows
    	//are able to process this file correctly (MacOS uses '\r'; and Windows uses '\r\n').
    	settings.getFormat().setLineSeparator("\n");

    	// creates a CSV parser
    	CsvParser parser = new CsvParser(settings);

    	// parses all rows in one go.
    	try {
    		List<String[]> allRows = parser.parseAll(getReader(csvFileName));
    		return allRows;
    	} catch (UnsupportedEncodingException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public String tableLookUp(List<String[]> table, int val1, int val2){
    	String [] heading = table.get(0);
//    	System.out.println("what is tables size" + table.size());
    	for (String [] row: table){
//    		System.out.println("Val 1: " + val1 + " and row[0]: "+ row[0]);
    		if (row[0].equals(Integer.toString(val1))){
    			int colNum = -1;
    			for (int i = 0; i < heading.length; i++){
    				if (heading[i].equals(Integer.toString(val2))){
    					colNum = i;
    				}
    			}
    			return row[colNum];
    		}
    	}
    	return "";
    }
    
}


