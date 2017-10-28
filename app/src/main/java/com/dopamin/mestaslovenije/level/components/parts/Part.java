package com.dopamin.mestaslovenije.level.components.parts;

import com.dopamin.mestaslovenije.level.components.Component;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.math.Vector2f;

public abstract class Part extends Component {

	protected Stage stage;

	public Part(Stage stage) {
		this.stage = stage;

		active = false;
	}

	@Override
	public boolean processInput(Vector2f input) {
		return active;
	}

}
