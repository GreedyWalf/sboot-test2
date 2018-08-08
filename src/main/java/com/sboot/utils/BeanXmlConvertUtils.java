package com.sboot.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class BeanXmlConvertUtils {
    /**
     * 对象转成xml
     *
     * @param obj
     * @param load
     * @return
     * @throws JAXBException
     */
    public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    /**
     * xml转成bean
     *
     * @param xml
     * @return
     * @throws JAXBException
     */
    public static Object xmlToBean(String xml, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Object) unmarshaller.unmarshal(new StringReader(xml));
    }

    /**
     * @param obj
     * @param load
     * @param characterSet 字符集
     * @return
     * @throws JAXBException
     * @Description: 实体转xml
     * @time : 2017年11月1日 上午11:40:02
     */
    public static String beanToXml(Object obj, Class<?> load, String characterSet) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, characterSet);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString().replace(" standalone=\"yes\"", "");
    }
}
