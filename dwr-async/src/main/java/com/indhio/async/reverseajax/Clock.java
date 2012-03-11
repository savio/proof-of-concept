package com.indhio.async.reverseajax;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.ScriptSessions;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.impl.DaemonThreadFactory;
import org.directwebremoting.ui.dwr.Util;

public class Clock implements Runnable {
	private static String UPDATES_ENABLED_ATTR = "UPDATES_ENABLED";

	protected transient boolean active = false;

	protected String timeString = "";

	public Clock() {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new DaemonThreadFactory());
		executor.scheduleAtFixedRate(this, 1L, 50L, TimeUnit.MILLISECONDS);
	}

	public void run() {
		if (this.active) {
			String newTimeString = new Date().toString();

			if (!newTimeString.equals(this.timeString)) {
				setClockDisplay(newTimeString);
				this.timeString = newTimeString;
			}
		}
	}

	public synchronized void toggle() {
		this.active = (!this.active);
		setClockStatus();
	}

	public void setClockStatus() {
		Browser.withAllSessions(new Runnable() {
			public void run() {
				ScriptSessions.addFunctionCall("setClockStatus", new Object[] { Boolean.valueOf(Clock.this.active) });
			}
		});
	}

	public void setClockDisplay(final String output) {
		Browser.withAllSessionsFiltered(new UpdatesEnabledFilter(UPDATES_ENABLED_ATTR), new Runnable() {
			public void run() {
				Util.setValue("clockDisplay", output);
			}
		});
	}

	public void setEnabledAttribute(Boolean enabled) {
		ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
		scriptSession.setAttribute(UPDATES_ENABLED_ATTR, enabled);
	}

	private class UpdatesEnabledFilter implements ScriptSessionFilter {
		private String attrName;

		public UpdatesEnabledFilter(String attrName) {
			this.attrName = attrName;
		}

		public boolean match(ScriptSession ss) {
			Object check = ss.getAttribute(this.attrName);
			return (check != null) && (check.equals(Boolean.TRUE));
		}
	}
}