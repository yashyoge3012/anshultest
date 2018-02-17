package com.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element; 
import org.w3c.dom.NodeList;

public class XmlParser {

	public static HashMap<String, String> getDataNode (InputStream xmlStream, String dataValue){
		try {
			HashMap<String, String> hm = new HashMap<String, String>();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlStream);
			doc.getDocumentElement().normalize();
			NodeList fStoreNodeLst = doc.getElementsByTagName("AddressMenu");

			for (int s = 0; s < fStoreNodeLst.getLength(); s++) {
				NodeList sStoreNodeLst = fStoreNodeLst.item(s).getChildNodes();
				for (int t = 1; t < sStoreNodeLst.getLength(); t++) {
					Node fst1StoreNode = sStoreNodeLst.item(t);
						if (fst1StoreNode.getNodeName().equals(dataValue)){
						
					//	if (fst1StoreNode.getNodeName() == dataValue){
					    NodeList fst1StoreNodeLst = sStoreNodeLst.item(t).getChildNodes();
			    		for (int u = 1; u < fst1StoreNodeLst.getLength(); u++) {
			    			hm.put(fst1StoreNodeLst.item(u).getNodeName(), fst1StoreNodeLst.item(u).getTextContent());
			    		   
			    		
			    		}
			    		return hm;
			    	}
				}
				NodeList fGSINodeLst = doc.getElementsByTagName("AddressMenu");

				for (int v = 0; v < fGSINodeLst.getLength(); v++) {
					NodeList sGSINodeLst = fGSINodeLst.item(v).getChildNodes();
					for (int w = 1; w < sGSINodeLst.getLength(); w++) {
						Node fst1GSINode = sGSINodeLst.item(w);
						if (fst1GSINode.getNodeName() == dataValue){
							NodeList fst1GSINodeLst = sGSINodeLst.item(w).getChildNodes();
							for (int x = 1; x < fst1GSINodeLst.getLength(); x++) {
								hm.put(fst1GSINodeLst.item(x).getNodeName(), fst1GSINodeLst.item(x).getTextContent());
							
							}
							return hm;
						}
					}
				}
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

	public static HashMap<String, String> getDataNode (InputStream xmlStream, String dataValue, String storeCode){
		try {
			HashMap<String, String> hm = new HashMap<String, String>();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlStream);
			doc.getDocumentElement().normalize();
			NodeList fStoreNodeLst = doc.getElementsByTagName(storeCode);

			for (int s = 0; s < fStoreNodeLst.getLength(); s++) {
				NodeList sStoreNodeLst = fStoreNodeLst.item(s).getChildNodes();
				for (int t = 1; t < sStoreNodeLst.getLength(); t++) {
					Node fst1StoreNode = sStoreNodeLst.item(t);
					if (fst1StoreNode.getNodeName() == dataValue){
					    NodeList fst1StoreNodeLst = sStoreNodeLst.item(t).getChildNodes();
			    		for (int u = 1; u < fst1StoreNodeLst.getLength(); u++) {
			    			hm.put(fst1StoreNodeLst.item(u).getNodeName(), fst1StoreNodeLst.item(u).getTextContent());
			    		}
			    		return hm;
			    	}
				}
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

	public static HashMap<String, String> getDataNode (File xmlFile, String dataValue){
		try {
			return getDataNode(new FileInputStream(xmlFile), dataValue);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

   



}
