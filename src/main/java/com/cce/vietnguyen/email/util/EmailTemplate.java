/**
 * 
 */
package com.cce.vietnguyen.email.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Map;

import com.cce.vietnguyen.util.AppUtil;
import com.cce.vietnguyen.util.Constants;

/**
 * @author pavan.solapure
 *
 */
public class EmailTemplate {

	private String templateId;

	private String template;

	private Map<String, String> replacementParams;

	public EmailTemplate(String templateId) {
		this.templateId = templateId;
		try {
			this.template = loadTemplate(templateId);
		} catch (Exception e) {
			this.template = Constants.BLANK;
		}
	}

	private String loadTemplate(String templateId) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("static/email-templates/" + templateId).getFile());
		String content = Constants.BLANK;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
			String readLine;

			while ((readLine = in.readLine()) != null) {
				content += readLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public String getTemplate(Map<String, String> replacements) {
		String cTemplate = this.getTemplate();

		if (!AppUtil.isObjectEmpty(cTemplate)) {
			for (Map.Entry<String, String> entry : replacements.entrySet()) {
				if(entry.getKey() != null){
					
					if(entry.getValue() == null){
						entry.setValue("");
					}
				cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
				}
			}
		}

		return cTemplate;
	}

	/**
	 * @return the templateId
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId
	 *            the templateId to set
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template
	 *            the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the replacementParams
	 */
	public Map<String, String> getReplacementParams() {
		return replacementParams;
	}

	/**
	 * @param replacementParams
	 *            the replacementParams to set
	 */
	public void setReplacementParams(Map<String, String> replacementParams) {
		this.replacementParams = replacementParams;
	}

}
