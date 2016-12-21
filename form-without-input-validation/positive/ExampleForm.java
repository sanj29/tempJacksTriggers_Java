package com.test.validation;

public class ExampleForm extends ActionForm {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// create a new instance of actionerrors
		ActionErrors actionErrors = new ActionErrors();

		// valdiate name
		if (name.length() < 3) {
			actionErrors.add("name", new ActionMessage("error.name"));
		}

		// validate age
		if (age == null || age < 18) {
			actionErrors.add("age", new ActionMessage("error.age"));
		}

		// return collection of action messages
		return actionErrors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// reset properties
		name = "";
		age = 0;

	}
	
}
