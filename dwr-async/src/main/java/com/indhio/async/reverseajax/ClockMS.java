package com.indhio.async.reverseajax;

import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.directwebremoting.Browser;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.impl.DaemonThreadFactory;
import org.directwebremoting.ui.dwr.Util;

public class ClockMS implements Runnable {
	protected transient boolean active = false;

	protected String timeString = "";

	public ClockMS() {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory());
		executor.scheduleAtFixedRate(this, 1L, 50L, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) {
		System.out.println(1000);
	}

	public void run() {
		if (this.active) {
			Calendar cal = Calendar.getInstance();
			int ms = cal.get(14);
			String newTimeString = cal.getTime().toString() + " MS:" + (ms - ms % 250);

			if (!newTimeString.equals(this.timeString)) {
				setClockDisplay(newTimeString);
				this.timeString = newTimeString;
			}
		}
	}

	public synchronized void toggle() {
		this.active = (!this.active);

		if (this.active) {
			setClockDisplay("Started");
		} else {
			setClockDisplay("Stopped");
		}
	}

	public void setClockDisplay(final String output) {
		String page = ServerContextFactory.get().getContextPath() + "/reverseajax/clock_logging_ms.html";
		Browser.withPage(page, new Runnable() {
			public void run() {
				Util.setValue("clockDisplay", output);
			}
		});
	}
}