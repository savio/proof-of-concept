package com.indhio.locale;

import java.lang.reflect.Field;
import java.util.TimeZone;

import sun.util.calendar.ZoneInfoFile;

public class AjustaHorario {
	public static void main (String [] args) {
		Field field;
		try {
			// aqui utilizo reflection para conseguir acessar e alterar um
			// atributo privado
			field = ZoneInfoFile.class.getDeclaredField("zoneInfoObjects");
			field.setAccessible(true);
			// esse � um atributo static, que corresponde a uma Collection
			// que � onde ficam as informa��es em cache
			// ent�o "apagamos" o cache :-)
			field.set(null, null);
			// aqui apenas fazemos o Java reler as configura��es de seu
			// timezone default (obtido atrav�s do S.O.)
			TimeZone.setDefault(null);
			// naturalmente, num ambiente com restri��es de seguran�a esse
			// "truque" n�o ir� funcionar
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
}