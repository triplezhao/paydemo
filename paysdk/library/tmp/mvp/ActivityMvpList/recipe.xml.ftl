<?xml version="1.0"?>
<recipe>

    <merge from="AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <!-- Activity Layout -->
    <instantiate from="res/layout/activity_simple.xml.ftl"
              to="${escapeXmlAttribute(resOut)}/layout/${layoutActivityName}.xml" />
	<!-- item layout -->		  
	<instantiate from="res/layout/item_simple.xml.ftl"
              to="${escapeXmlAttribute(resOut)}/layout/item_${classToResource(mvpClass)}.xml" />

    <!-- Decide which activity code to add -->
    <instantiate from="src/app_package/SimpleActivity.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${activityClass}.java" />

    <instantiate from="src/app_package/mvp.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${mvpClass}.java" />
					   
	<instantiate from="src/app_package/presenter.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${presenterClass}.java" />

	<open file="${escapeXmlAttribute(srcOut)}/${activityClass}.java" />
    <open file="${escapeXmlAttribute(srcOut)}/${mvpClass}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${presenterClass}.java" />
   

</recipe>
