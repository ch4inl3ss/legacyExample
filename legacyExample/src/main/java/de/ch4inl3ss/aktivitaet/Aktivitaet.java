package de.ch4inl3ss.aktivitaet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;

import de.ch4inl3ss.entity.Programmer;
import de.ch4inl3ss.model.DataContainer;
import de.ch4inl3ss.model.State;
import de.ch4inl3ss.repository.ProgrammerRepository;

@Component
public class Aktivitaet {

	@Autowired
	private ProgrammerRepository programmerRepository;

	public String ausfuehrenImplementierung(String state, DataContainer dataContainer) {
		if (State.COMPLEX.getState().equals(state)) {

			// calculate the nth prime
			if (dataContainer.getInputComplex() != null) {
				List<Long> primes = new ArrayList<>();
				int whichPrime = Integer.parseInt(dataContainer.getInputComplex());
				primes.add(1l);
				primes.add(2l);
				long i = 2;
				primes: while (primes.size() < whichPrime) {
					if (i % 2 != 0) {
						for (Long prime : primes) {
							if (i % prime == 0) {
								i++;
								continue primes;
							}
						}
						primes.add(i);
					}
					i++;
				}
				dataContainer
						.setOutputComplex(primes.stream().map(l -> String.valueOf(l)).collect(Collectors.toList()));
			}
			return "complex";
		} else if (State.REMOTE.getState().equals(state)) {

			// Get a Weatherreport
			ForecastIO fio = new ForecastIO(dataContainer.getApiKey());
			fio.setUnits(ForecastIO.UNITS_SI);
			fio.setExcludeURL("hourly,minutely");
			fio.getForecast(dataContainer.getLatitude(), dataContainer.getLongitude());

			FIOCurrently currentlyWeather = new FIOCurrently(fio);
			dataContainer.setHumidity(String.valueOf(currentlyWeather.get().humidity()));
			dataContainer.setTemperature(String.valueOf(currentlyWeather.get().temperature()));
			dataContainer.setWindspeed(String.valueOf(currentlyWeather.get().windSpeed()));

			dataContainer.setLatitude("");
			dataContainer.setLongitude("");

			return "remote";

		} else if (State.DATABASE.getState().equals(state)) {
			// Put a new Programmer into the database

			Programmer newProgrammer = dataContainer.getProgrammer();
			programmerRepository.save(newProgrammer);
			dataContainer.setProgrammer(new Programmer());
			List<Programmer> programmers = new ArrayList<>();
			for (Programmer programmer : programmerRepository.findAll()) {
				programmers.add(programmer);
			}
			dataContainer.setProgrammers(programmers);
			return "database";
		} else {

			return "error";
		}
	}

}
