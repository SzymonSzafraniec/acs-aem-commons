package com.adobe.acs.commons.forms.helpers;

import com.adobe.acs.commons.forms.Form;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;

import javax.servlet.ServletException;
import java.io.IOException;

public interface FormHelper {
    public static final String SELECTOR = "post";
    public static final String EXTENSION = ".html";

    public static final String FORM_NAME_INPUT = ":form";
    public static final String FORM_RESOURCE_INPUT = ":formResource";
    public static final String FORM_SELECTOR_INPUT = ":formSelector";
    public static final String[] FORM_INPUTS = { FORM_NAME_INPUT, FORM_RESOURCE_INPUT, FORM_SELECTOR_INPUT };

    /**
	 * Gets the From from either the POST Requests parameters or the GET
	 * request's (synthetic) attributes.
	 * 
	 * @param formName
	 * @param request
	 * @return
	 */
	public Form getForm(String formName, SlingHttpServletRequest request);

	/**
	 * Returns a series of hidden fields used to persist multi-page form data
	 * between forms.
	 * 
	 * @param form
	 * @param keys
	 * @return
	 * @throws java.io.IOException
	 */
	public String getFormInputsHTML(Form form, String... keys);

    /**
     * Returns an input type="hidden" used to override the selector used for resolving
     * the custom script used to handle the POST.
     *
     * If not set/used, defaults to "post"
     *
     * @param selector
     * @return
     */
    public String getFormSelectorInputHTML(final String selector);

    /**
     * Builds the form's action URI based on the provided resource's path
     *
     * Appends ".post.html" to the resource's path.
     *
     * @param resource
     * @return
     */
    public String getAction(final Resource resource);

    /**
     * Builds the form's action URI based on the provided page's path
     *
     * Appends ".html/<suffix>" to the resource's path.
     *
     * @param page
     * @return
     */
    public String getAction(final Page page);

    /**
     * Builds the form's action URI based on the provided path
     *
     * Appends ".html/<suffix>" to the resource's path.
     *
     * @param path
     * @return
     */
    public String getAction(final String path);

    /**
     * Wrapped method to create a interface from FormHelper to normalize APIs that are commonly used.
     *
     *  - Wraps implementing FormHelper's `render(..)` method (sendRedirect or forwardAsGet) in the implementing FormHelper
     *
     * @param form
     * @param path
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws JSONException
     */
    public void renderForm(Form form, String path, SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException, ServletException, JSONException;

    /**
     * Wrapped method to create a interface from FormHelper to normalize APIs that are commonly used.
     *
     *  - Wraps implementing FormHelper's `render(..)` method (sendRedirect or forwardAsGet) in the implementing FormHelper
     *
     *  @param form
     * @param page
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws JSONException
     */
    public void renderForm(Form form, Page page, SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException, ServletException, JSONException;


    /**
     * Wrapped method to create a interface from FormHelper to normalize APIs that are commonly used.
     *
     *  - Wraps implementing `.renderForm(..)` method (sendRedirect or forwardAsGet) in the implementing FormHelper
     *
     * @param form
     * @param resource
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws JSONException
     */
    public void renderForm(Form form, Resource resource, SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException, ServletException, JSONException;

    /**
     * Wrapped method to create a interface from FormHelper to normalize APIs that are commonly used.
     *
     *  - Wraps implementing FormHelper's `render(..)` method (sendRedirect or forwardAsGet) in the implementing FormHelper
     *
     * @param form
     * @param path
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws JSONException
     */
    public void renderOtherForm(Form form, String path, String selectors, SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException, ServletException, JSONException;

    /**
     * Wrapped method to create a interface from FormHelper to normalize APIs that are commonly used.
     *
     *  - Wraps implementing FormHelper's `render(..)` method (sendRedirect or forwardAsGet) in the implementing FormHelper
     *
     *  @param form
     * @param page
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws JSONException
     */
    public void renderOtherForm(Form form, Page page, String selectors, SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException, ServletException, JSONException;


    /**
     * Wrapped method to create a interface from FormHelper to normalize APIs that are commonly used.
     *
     *  - Wraps implementing FormHelper's `render(..)` method (sendRedirect or forwardAsGet) in the implementing FormHelper
     *
     * @param form
     * @param resource
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws JSONException
     */
    public void renderOtherForm(Form form, Resource resource, String selectors, SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException, ServletException, JSONException;

}