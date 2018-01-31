package com.dopamin.mestaslovenije.math.timing;

import android.util.Log;

public class TimerLimit extends Timer {

	public Action action;
	public final float limit;
	
	public TimerLimit(float limit) {
		this(limit, null);
	}

	public TimerLimit(float limit, Action action) {
		super();
		this.limit = limit;
		this.action = action;
	}

	@Override
	public void update(float deltaTime) {
		//Log.e("Current time", time + " " + limit);
		if (!finished)
			super.update(deltaTime);

		if (time >= limit && !finished) {
			finished = true;
			time = limit;

			if (action != null)
				action.execute();
		}

	}

}
