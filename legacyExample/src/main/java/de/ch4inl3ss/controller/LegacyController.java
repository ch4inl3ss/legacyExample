package de.ch4inl3ss.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.ch4inl3ss.aktivitaet.Aktivitaet;
import de.ch4inl3ss.model.DataContainer;
import de.ch4inl3ss.model.State;

@Controller
public class LegacyController {

	private DataContainer dataContainer = new DataContainer();

	@Autowired
	private Aktivitaet aktivitaet;

	@RequestMapping(value = "/complex", method = RequestMethod.GET)
	public String complex(Model model) {
		model.addAttribute("dataContainer", dataContainer);
		return "complex";
	}

	@RequestMapping(value = "/complex", method = RequestMethod.POST)
	public String complexReturn(@ModelAttribute DataContainer dataContainer, Model model) {
		dataContainer.setOutputComplex(
				dataContainer.getOutputComplex() == null ? new ArrayList<String>() : dataContainer.getOutputComplex());
		String next = aktivitaet.ausfuehrenImplementierung(State.COMPLEX.getState(), dataContainer);
		return next;
	}

	@RequestMapping(value = "/database", method = RequestMethod.GET)
	public String database(Model model) {
		model.addAttribute("dataContainer", dataContainer);
		return "database";
	}

	@RequestMapping(value = "/database", method = RequestMethod.POST)
	public String databaseReturn(@ModelAttribute DataContainer dataContainer, Model model) {
		String next = aktivitaet.ausfuehrenImplementierung(State.DATABASE.getState(), dataContainer);
		return next;
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "remote", method = RequestMethod.GET)
	public String remote(Model model) {
		model.addAttribute("dataContainer", dataContainer);
		return "remote";
	}

	@RequestMapping(value = "/remote", method = RequestMethod.POST)
	public String remoteReturn(@ModelAttribute DataContainer dataContainer, Model model) {
		String next = aktivitaet.ausfuehrenImplementierung(State.REMOTE.getState(), dataContainer);
		return next;
	}
}
