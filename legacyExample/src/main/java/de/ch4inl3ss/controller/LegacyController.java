package de.ch4inl3ss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.ch4inl3ss.aktivitaet.Aktivitaet;
import de.ch4inl3ss.entity.Programmer;
import de.ch4inl3ss.model.DataContainer;
import de.ch4inl3ss.model.State;
import de.ch4inl3ss.repository.ProgrammerRepository;

@Controller
public class LegacyController {

	private DataContainer dataContainer = new DataContainer();

	@Autowired
	private Aktivitaet aktivitaet;

	@Autowired
	private ProgrammerRepository programmerRepository;

	@RequestMapping(value = "/complex", method = RequestMethod.GET)
	public String complex(Model model) {
		model.addAttribute("dataContainer", dataContainer);
		return "complex";
	}

	@RequestMapping(value = "/complex", method = RequestMethod.POST)
	public String complexReturn(@ModelAttribute DataContainer dataContainer, Model model) {
		dataContainer.setOutputComplex(
				dataContainer.getOutputComplex() == null ? new ArrayList<String>() : dataContainer.getOutputComplex());
		int whichPrime = Integer.parseInt(dataContainer.getInputComplex());
		String next = aktivitaet.ausfuehrenImplementierung(State.COMPLEX.getState(), dataContainer, whichPrime);
		return next;
	}

	@RequestMapping(value = "/database", method = RequestMethod.GET)
	public String database(Model model) {
		List<Programmer> programmers = new ArrayList<>();
		programmerRepository.findAll().forEach(p -> programmers.add(p));
		dataContainer.setProgrammers(programmers);
		dataContainer.setProgrammer(new Programmer());
		model.addAttribute("dataContainer", dataContainer);
		return "database";
	}

	@RequestMapping(value = "/database", method = RequestMethod.POST)
	public String databaseReturn(@ModelAttribute DataContainer dataContainer, Model model) {

		String next = aktivitaet.ausfuehrenImplementierung(State.DATABASE.getState(), dataContainer, 0);
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
		String next = aktivitaet.ausfuehrenImplementierung(State.REMOTE.getState(), dataContainer, 0);
		return next;
	}
}
