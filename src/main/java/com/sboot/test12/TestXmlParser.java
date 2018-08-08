package com.sboot.test12;


import com.sboot.test12.bean.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class TestXmlParser {

    public static void main(String[] args) throws Exception {
//        testBean2Xml();

        testXml2Bean();
    }

    public static void testBean2Xml() {
        try {
            JAXBContext jc = JAXBContext.newInstance(User.class);
            Marshaller ms = jc.createMarshaller();
            User user = new User();
            user.setUserName("zhangsan");
            user.setAge(20);
            ms.marshal(user, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void testXml2Bean() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user><age>20</age><userName>zhangsan</userName></user>";
        JAXBContext jc = JAXBContext.newInstance(User.class);
        Unmarshaller unmar = jc.createUnmarshaller();
        User user = (User) unmar.unmarshal(new StringReader(xml));
        System.out.println(user.getUserName());
        System.out.println(user.getAge());
    }


}
