package appmain;

// Taken From https://www.geeksforgeeks.org/stax-xml-parser-java/
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.util.Iterator;
import java.net.URL;
import javax.xml.namespace.QName; 
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory; 
import javax.xml.stream.XMLStreamException; 
import javax.xml.stream.events.*; 

public class XMLReaderAndWriter 
{ 
	static URL fileURL = XMLReaderAndWriter.class.getResource("Task.xml");
	private static boolean Task,TName,TPart,TDesc; 
	static String TaskName;
	
	public static void main(String[] args) throws XMLStreamException, FileNotFoundException 
	{
		FileFind();
	}

	 public static void FileFind() throws XMLStreamException, FileNotFoundException 
	 { 
		 
	     File file = new File(fileURL.getPath()); 
	     	
	     parser(file); 
	 } 
	
	 public static void parser(File file) throws XMLStreamException, FileNotFoundException 
	 { 
	     Task = TName = TPart = TDesc = false; 
	
	     XMLInputFactory factory = XMLInputFactory.newInstance(); 
	
	     XMLEventReader eventReader = 
	              factory.createXMLEventReader(new FileReader(file)); 
	 
	     while (eventReader.hasNext()) 
	     { 
	         // Event is actually the tag . It is of 3 types 
	         // <name> = StartEvent 
	         // </name> = EndEvent 
	         // data between the StartEvent and the EndEvent 
	         // which is Characters Event 
	         XMLEvent event = eventReader.nextEvent(); 
	
	         // This will trigger when the tag is of type <...> 
	         if (event.isStartElement()) 
	         { 
	             StartElement element = (StartElement)event; 
	
	             // Iterator for accessing the metadeta related 
	             // the tag started. 
	             // Here, it would name of the company 
	             /*Iterator<Attribute> iterator = element.getAttributes(); 
	             while (iterator.hasNext()) 
	             { 
	                 //Attribute attribute = iterator.next(); 
	                 //QName name = attribute.getName(); 
	                 //String value = attribute.getValue(); 
	                 //System.out.println(name+" = " + value); 
	             }*/
	
	             // Checking which tag needs to be opened for reading. 
	             // If the tag matches then the boolean of that tag 
	             // is set to be true. 
	             if (element.getName().toString().equalsIgnoreCase("task")) 
	             { 
	                 Task = true; 
	             } 

	             if (element.getName().toString().equalsIgnoreCase("tname")) 
	             { 
	                 TName = true; 
	             } 

	             if (element.getName().toString().equalsIgnoreCase("tpart")) 
	             { 
	                 TPart = true; 
	             }

	             if (element.getName().toString().equalsIgnoreCase("tdesc")) 
	             {
	            	 TDesc = true;
	             }
	         } 
	
	         // This will be triggered when the tag is of type </...> 
	         if (event.isEndElement()) 
	         { 
	             EndElement element = (EndElement) event; 
	
	             // Checking which tag needs to be closed after reading. 
	             // If the tag matches then the boolean of that tag is 
	             // set to be false. 
	             if (element.getName().toString().equalsIgnoreCase("task")) 
	             { 
	                 Task = false; 
	             } 

	             if (element.getName().toString().equalsIgnoreCase("tname")) 
	             { 
	                 TName = false; 
	             } 

	             if (element.getName().toString().equalsIgnoreCase("tpart")) 
	             { 
	                 TPart = false; 
	             }

	             if (element.getName().toString().equalsIgnoreCase("tdesc")) 
	             {
	            	 TDesc = false;
	             }
	         } 
	
	         // Triggered when there is data after the tag which is 
	         // currently opened. 
	         if (event.isCharacters()) 
	         { 
	             // Depending upon the tag opened the data is retrieved . 
	             Characters element = (Characters) event; 
	             if (Task) 
	             { 
	            	 if (element.getData().length() < 1) {
	            		System.out.println(element.getData()); 
	            		Task = false; 
	            	 }
	            	 else {
	            		 Task = false;
	            	 }
	                 
	             } 
	           
	             if (TName) 
	             { 
	            	 TaskName = element.getData();
	                 //System.out.println(element.getData()); 
	                 TName = false;
	             } 
	           
	             if (TPart) 
	             { 
	                 //System.out.println(element.getData()); 
	                 TPart = false;
	             } 

	             if (TDesc) 
	             { 
	                 //System.out.println(element.getData());
	                 TDesc = false;
	             }
	         } 
	     } 
	 } 
} 