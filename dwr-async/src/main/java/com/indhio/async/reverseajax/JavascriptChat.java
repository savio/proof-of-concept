package com.indhio.async.reverseajax;

import java.util.LinkedList;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;

public class JavascriptChat {
	/**
	 * @param text
	 *          The new message text to add
	 */
	public void addMessage(String text) {
		if (text != null && text.trim().length() > 0) {
			messages.addFirst(new Message(text));
			while (messages.size() > 10) {
				messages.removeLast();
			}
		}

		Browser.withCurrentPage(new Runnable() {
			public void run() {
				ScriptSessions.addFunctionCall("receiveMessages", messages);
			}
		});
	}

	/**
	 * The current set of messages
	 */
	private final LinkedList<Message> messages = new LinkedList<Message>();
}