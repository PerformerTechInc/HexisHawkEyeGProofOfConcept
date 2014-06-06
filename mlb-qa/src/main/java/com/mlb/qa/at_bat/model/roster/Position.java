package com.mlb.qa.at_bat.model.roster;

import com.mlb.qa.common.exception.TestRuntimeException;

public class Position {
	
	public enum PositionText {
		CATCHER("Catcher"),
		FIRST_BASE("First Base"),
		SECOND_BASE("Second Base"),
		THIRD_BASE("Third Base"),
		SHORTSTOP("Shortstop"),
		INFIELD("Infield"),
		LEFT_FIELD("Left Field"),
		CENTER_FIELD("Center Field"),
		RIGHT_FIELD("Right Field"),
		OUTFIELD("Outfield"),
		PITCHER("Pitcher"),
		DESIGNATED_HITTER("Designated Hitter");
	
		private String positionText;
	
		private PositionText(String positionText) {
			this.positionText = positionText;
		}

		public String getPositionText() {
			return this.positionText;
		}
		
		public static PositionText getPositionEnum(String positionText) {
			for (PositionText position: values()) {
				if (position.getPositionText().equalsIgnoreCase(positionText)) {
					return position;
				}
			}
			throw new TestRuntimeException(String.format("Position Passed (Text) is not Found: %s", positionText));
		}
	}
	
	public enum PositionShortCode {
		CATCHER("C"),
		FIRST_BASE("1B"),
		SECOND_BASE("2B"),
		THIRD_BASE("3B"),
		SHORTSTOP("SS"),
		INFIELD("IF"),
		LEFT_FIELD("LF"),
		CENTER_FIELD("CF"),
		RIGHT_FIELD("RF"),
		OUTFIELD("OF"),
		PITCHER("P"),
		DESIGNATED_HITTER("DH");
		
		private String positionShort;
		
		private PositionShortCode(String positionShort) {
			this.positionShort = positionShort;
		}
		
		public String getPositionShort() {
			return this.positionShort;
		}
		
		public static PositionShortCode getPositionEnum(String positionText) {
			for (PositionShortCode position: values()) {
				if (position.getPositionShort().equalsIgnoreCase(positionText)) {
					return position;
				}
			}
			throw new TestRuntimeException(String.format("Position Passed (Shortcode) is not Found: %s", positionText));
		}
	}
}
