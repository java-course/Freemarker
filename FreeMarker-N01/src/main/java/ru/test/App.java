package ru.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class App {

    public static void main(String[] args) throws IOException, TemplateException, SAXException, ParserConfigurationException {
        Configuration cfg = new Configuration();

//        simpleOutput(cfg);
//
//        newBracketsStyle(cfg);
//
//        xmlAsSourceForeach(cfg);
//
//        ifCondition(cfg);

//        textFileExample(cfg);

        assignTest(cfg);
    }

    public static void simpleOutput(Configuration cfg) throws IOException, TemplateException {
        Map datamodel = new HashMap();
        datamodel.put("paramValue", "Here is a value");
        datamodel.put("number", new Integer(6));
        Template tpl = cfg.getTemplate("src/main/resources/ru/test/template.html");
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        tpl.process(datamodel, output);
    }

    public static void newBracketsStyle(Configuration cfg) throws IOException, TemplateException {
        Map datamodel = new HashMap();
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("John Smith", "3033 Long Drive, Houston, TX"));
        list.add(new Person("Janet Mason", "11c Poplar Drive, Knoxville, TN"));
        datamodel.put("doc", list);
        Template tpl = cfg.getTemplate("src/main/resources/ru/test/listTemplate.html");
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        tpl.process(datamodel, output);
    }

    public static void xmlAsSourceForeach(Configuration cfg) throws IOException, TemplateException, ParserConfigurationException, SAXException {
        Map datamodel = new HashMap();
        File document = new File("src/main/resources/ru/test/inputXML.xml");
        datamodel.put("doc", freemarker.ext.dom.NodeModel.parse(document));
        Template tpl = cfg.getTemplate("src/main/resources/ru/test/xmlTemplate.html");
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        tpl.process(datamodel, output);
    }

    public static void ifCondition(Configuration cfg) throws IOException, TemplateException {
        Map datamodel = new HashMap();
        datamodel.put("number", new Integer(1));
        datamodel.put("object", new Object());
        datamodel.put("another", null);
        Template tpl = cfg.getTemplate("src/main/resources/ru/test/condTemplate.html");
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        tpl.process(datamodel, output);
    }

    public static void textFileExample(Configuration cfg) throws IOException, TemplateException {
        Template tpl = cfg.getTemplate("src/main/resources/ru/test/textFile.ftl");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", "Hello World!");

        List<String> countries = new ArrayList<String>();
        countries.add("India");
        countries.add("United States");
        countries.add("Germany");
        countries.add("France");
        data.put("countries", countries);
        // Console output
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        tpl.process(data, output);


        // File output
        Writer file = new FileWriter(new File("countries.txt"));
        tpl.process(data, file);
        file.flush();
        file.close();

    }

    public static void assignTest(Configuration cfg) throws IOException, TemplateException {
        Map datamodel = new HashMap();
        datamodel.put("test", new Integer(1));
        datamodel.put("s", "Old String");
        Template tpl = cfg.getTemplate("src/main/resources/ru/test/assign.ftl");
        OutputStreamWriter output = new OutputStreamWriter(System.out);
        tpl.process(datamodel, output);
    }


}
