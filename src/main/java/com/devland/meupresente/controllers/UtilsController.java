package com.devland.meupresente.controllers;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class UtilsController {

/*classe especial para fazer a cópia de objetos durante atualização de dados, ou seja pegar pra salvar apenas os  
atributos não nulos que foram modificados, basta passar como parâmetros o objeto que quer copiar as informações
para o objeto que de fato vai salvar no banco */

	  public static void copyNonNullProperty(Object source, Object target) {
	    BeanUtils.copyProperties(source, target, getNullPropriertyNames(source));
	  }

	  public static String[] getNullPropriertyNames(Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);

	    PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<>();

	    for (PropertyDescriptor pd : pds) {
	      Object srcValue = src.getPropertyValue(pd.getName());
	      if (srcValue == null) {
	        emptyNames.add(pd.getName());
	      }
	    }

	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	  
	}
}
