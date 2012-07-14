package com.indhio.generics;

import java.util.ArrayList;
import java.util.List;

public abstract class ClasseGenerica<T> {
	
	public void salvar(T obj) {
		
	}
	
	public List<T> listar() {
		return new ArrayList<T>();
	}
	
}
