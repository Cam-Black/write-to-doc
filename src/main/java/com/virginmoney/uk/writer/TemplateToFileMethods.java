package com.virginmoney.uk.writer;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.List;

public interface TemplateToFileMethods<T> {
	XWPFDocument createDoc();
	void populateAndSaveDoc(List<T> obj);
	String convertObjToString(List<T> obj);
}