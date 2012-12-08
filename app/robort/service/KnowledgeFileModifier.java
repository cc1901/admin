package robort.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;
import play.Logger;
import robort.util.KnowledgeFileParser;

import java.io.*;

public class KnowledgeFileModifier {
    public void modifyKnowledgeFile(String knowledgeFile, String answer, String newQuestionText) {
        try {
            SAXReader reader = new SAXReader(false);
            DocumentFactory factory = new DocumentFactory();
            reader.setDocumentFactory(factory);
            reader.setDefaultHandler(new KnowledgeFileParser(answer, newQuestionText));
            FileInputStream fileInputStream = new FileInputStream(knowledgeFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            Document document = reader.read(inputStreamReader);
            inputStreamReader.close();
            FileWriter out = new FileWriter(knowledgeFile);
            document.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            Logger.error("knowledge file can not be found...");
            throw new RuntimeException("knowledge file can not be found...");
        } catch (UnsupportedEncodingException e) {
            Logger.error("encoding not supported...");
            throw new RuntimeException("encoding not supported...");
        } catch (DocumentException e) {
            Logger.error("parse xml document failed...");
            throw new RuntimeException("parse document failed...");
        } catch (IOException e) {
            Logger.error("write xml file failed...");
            throw new RuntimeException("read file failed...");
        }
    }
}
