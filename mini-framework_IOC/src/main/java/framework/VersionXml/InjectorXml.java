package framework.VersionXml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InjectorXml {
    String FileName;
    File file;
    HashMap<String, Object> Objects = new HashMap<String, Object>();

    public InjectorXml(String fileName) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        FileName = fileName;
        file = new File(fileName);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("bean");

        for (int itr = 0; itr < nodeList.getLength(); itr++)
        {

            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {

                Element eElement = (Element) node;

                String ObName = eElement.getAttribute("class");
                String ObId = eElement.getAttribute("id");

                Class instance =Class.forName(ObName);

                Object ObjectInstance =  instance.newInstance();

                Objects.put(ObId,ObjectInstance);

                NodeList nodeList2 = ((Element) node).getElementsByTagName("property") ;

                if(nodeList2.getLength() > 0){

                    for (int itr2 = 0; itr2 < nodeList2.getLength(); itr2++)
                    {

                        Node node2 = nodeList2.item(itr2);
                        if (node.getNodeType() == Node.ELEMENT_NODE)
                        {

                            Element eElement2 = (Element) node2;

                            String ProbName = eElement2.getAttribute("name");

                            ProbName = ProbName.substring(0,1).toUpperCase() + ProbName.substring(1).toLowerCase();

                            String ProbObject = eElement2.getAttribute("ref");

                            Method meth=findMethod(ObjectInstance,"set"+ProbName,(Objects.get(ProbObject)).getClass());

                            meth.invoke(ObjectInstance,Objects.get(ProbObject));
                        }}
                }

                NodeList nodeList3 = ((Element) node).getElementsByTagName("constructor-arg") ;

                if(nodeList3.getLength() > 0){
                    HashMap<Integer, Class> ListParms = new HashMap<>();
                    HashMap<Integer,Object>  B = new HashMap<>();

                    for (int itr2 = 0; itr2 < nodeList3.getLength(); itr2++)
                    {
                        Node node2 = nodeList3.item(itr2);
                        if (node.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element eElement2 = (Element) node2;

                            Integer index = Integer.parseInt(eElement2.getAttribute("index"));

                            String value = eElement2.getAttribute("value");

                            ListParms.put(index,Objects.get(value).getClass());

                            B.put(index,Objects.get(value));
                        }}

                    Class [] A= new Class[ListParms.size()];
                    for (int i=0;i<ListParms.size();i++){
                        A[i] = ListParms.get(i);
                    }

                    Object [] Objs= new Object[B.size()];
                    for (int i=0;i<B.size();i++){
                        Objs[i] = B.get(i);
                    }

                    Object ob = findConstructor(ObjectInstance,ObjectInstance.getClass().toString(),A).newInstance(Objs);
                    Objects.put(ObId,ob);

                }
            }}


    }

    public Object getBean(String BeanName){
        return Objects.get(BeanName);
    }

    public static Method findMethod(Object m, String methodName, Class DepType) throws NoSuchMethodException {

        Method[] metody = m.getClass().getDeclaredMethods();

        List<Method> sameNames = new ArrayList<Method>();

        for (Method meth : metody) {

            if (meth.getName().equals(methodName)) {
                sameNames.add(meth);
            }
        }
        if (sameNames.isEmpty()) {
            throw new NoSuchMethodException();
        } else {

            List<Method> sameCountOfParameters = new ArrayList<Method>();

            for (Method meth : sameNames) {

                if (meth.getParameterTypes().length == 1) {
                    sameCountOfParameters.add(meth);
                }
            }
            if (sameCountOfParameters.isEmpty()) {
                throw new NoSuchMethodException();
            } else {
                for (Method meth : sameCountOfParameters) {

                    Class<?>[] params = meth.getParameterTypes();
                    boolean good = true;
                    for (int i = 0; i < params.length && good; i++) {
                        if (params[i].isInterface() && Arrays.asList(DepType.getInterfaces()).contains(params[i])) {
                            good = true;
                            continue;
                        } else {
                            if (DepType.getSuperclass().equals(params[i])) {
                                good = true;
                                continue;
                            }
                            else if(DepType.equals(params[i])){
                                good = true;
                                continue;
                            }
                        }

                        good = false;
                    }

                    if (good) {
                        return meth;
                    }
                }
            }
        }

        throw new NoSuchMethodException();
    }







    public static Constructor findConstructor(Object m, String methodName, Class[] DepType) throws NoSuchMethodException {

        Constructor[] metody = m.getClass().getDeclaredConstructors();

        List<Constructor> sameCountOfParameters = new ArrayList<Constructor>();
        for (Constructor meth : metody) {

            if (meth.getParameterTypes().length == 1) {
                sameCountOfParameters.add(meth);
            }
        }
        if (sameCountOfParameters.isEmpty()) {
            throw new NoSuchMethodException();
        } else {

            for (Constructor meth : sameCountOfParameters) {

                Class<?>[] params = meth.getParameterTypes();

                boolean good = true;
                for (int i = 0; i < params.length && good; i++) {
                    if (params[i].isInterface() && Arrays.asList(DepType[i].getInterfaces()).contains(params[i])) {
                        good = true;
                        continue;
                    } else {
                        if (DepType[i].getSuperclass().equals(params[i])) {
                            good = true;
                            continue;
                        }
                        else if (DepType.equals(params[i])) {
                            good = true;
                            continue;
                        }
                    }
                    good = false;
                }
                if (good) {
                    return meth;
                } else {
                    throw new NoSuchMethodException();

                }
            }
        }
        return null;
    }


}
