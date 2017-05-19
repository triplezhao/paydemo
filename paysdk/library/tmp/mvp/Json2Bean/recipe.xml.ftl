<?xml version="1.0"?>
<recipe>

     <!-- Decide which activity code to add -->
    <instantiate from="src/app_package/javabean.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${beanClass}.java" />

    <instantiate from="src/app_package/dao.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${beanClass}Dao.java" />
					   
	<open file="${escapeXmlAttribute(srcOut)}/${beanClass}.java" />
    <open file="${escapeXmlAttribute(srcOut)}/${beanClass}Dao.java" />

   

</recipe>
