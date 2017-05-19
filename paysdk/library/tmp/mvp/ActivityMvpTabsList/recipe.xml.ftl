<?xml version="1.0"?>
<recipe>

    <!-- activity  -->
	<!-- manifest.xml  -->
    <merge from="AndroidManifest.xml.ftl"
             to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <!-- tabsActivity Layout -->
    <instantiate from="res/layout/activity_simple.xml.ftl"
              to="${escapeXmlAttribute(resOut)}/layout/${layoutActivityName}.xml" />

    <!-- tabs activity -->
    <instantiate from="src/app_package/SimpleActivity.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${activityClass}.java" />

    <instantiate from="src/app_package/mvp.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${mvpClass}.java" />
					   
	<instantiate from="src/app_package/presenter.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${presenterClass}.java" />

	
	
	
	
	<!-- fragment  -->
	<!-- fragment layout -->			  
	<instantiate from="res/layout/fragment_simple.xml.ftl"
              to="${escapeXmlAttribute(resOut)}/layout/${layoutFragmentName}.xml" />		  
	<!-- item layout -->		  
	<instantiate from="res/layout/item_simple.xml.ftl"
              to="${escapeXmlAttribute(resOut)}/layout/item_${classToResource(fragmentMvpClass)}.xml" />
			  
	<instantiate from="src/app_package/SimpleFragment.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${fragmentClass}.java" />

    <instantiate from="src/app_package/fragmentMvp.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${fragmentMvpClass}.java" />
					   
	<instantiate from="src/app_package/fragmentPresenter.java.ftl"
                       to="${escapeXmlAttribute(srcOut)}/${fragmentPresenterClass}.java" />

					   
	<open file="${escapeXmlAttribute(srcOut)}/${activityClass}.java" />
    <open file="${escapeXmlAttribute(srcOut)}/${mvpClass}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${presenterClass}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${fragmentClass}.java" />
    <open file="${escapeXmlAttribute(srcOut)}/${fragmentMvpClass}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${fragmentPresenterClass}.java" />
   

</recipe>
