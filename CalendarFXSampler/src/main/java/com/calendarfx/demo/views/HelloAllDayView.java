/**
 * Copyright (C) 2015, 2016 Dirk Lemmermann Software & Consulting (dlsc.com) 
 * 
 * This file is part of CalendarFX.
 */

package com.calendarfx.demo.views;

import com.calendarfx.demo.CalendarFXDateControlSample;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.AllDayView;
import com.calendarfx.view.DateControl;
import javafx.beans.binding.Bindings;

import java.time.LocalDate;

public class HelloAllDayView extends CalendarFXDateControlSample {

	private AllDayView allDayView;

	@Override
	public String getSampleName() {
		return "All Day View";
	}

	@Override
	protected DateControl createControl() {
        CalendarSource calendarSource = new CalendarSource();
        calendarSource.getCalendars().add(new HelloCalendar());

        allDayView = new AllDayView();
		allDayView.prefWidthProperty().bind(Bindings.multiply(150, allDayView.numberOfDaysProperty()));
		allDayView.setMaxWidth(Double.MAX_VALUE);
        allDayView.getCalendarSources().add(calendarSource);

        return allDayView;
	}

	@Override
	protected Class<?> getJavaDocClass() {
		return AllDayView.class;
	}

	@Override
	public String getSampleDescription() {
		return "The all-day view displays entries that last all day / span multiple days.";
	}

	class HelloCalendar extends Calendar {

		public HelloCalendar() {
			Entry<?> entry1 = new Entry<>("Entry 1");
			Entry<?> entry2 = new Entry<>("Entry 2");
			Entry<?> entry3 = new Entry<>("Entry 3");
			Entry<?> entry4 = new Entry<>("Entry 4");
			Entry<?> entry5 = new Entry<>("Entry 5");

			entry1.setInterval(LocalDate.now(), LocalDate.now().plusDays(2));
			entry2.setInterval(LocalDate.now().plusDays(3), LocalDate.now().plusDays(4));
			entry3.setInterval(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
			entry4.setInterval(LocalDate.now(), LocalDate.now().plusDays(4));
			entry5.setInterval(LocalDate.now().plusDays(4), LocalDate.now().plusDays(6));

			entry1.setFullDay(true);
			entry2.setFullDay(true);
			entry3.setFullDay(true);
			entry4.setFullDay(true);
			entry5.setFullDay(true);

			entry1.setCalendar(this);
			entry4.setCalendar(this);
			entry3.setCalendar(this);
			entry2.setCalendar(this);
			entry5.setCalendar(this);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
