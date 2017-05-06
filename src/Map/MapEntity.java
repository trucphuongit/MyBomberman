package Map;

public enum MapEntity {
		W("Wall"), N("None"), E("Enemy"), P("Player"), B("Bomb"), R("Brick");
		private String name;

		private MapEntity(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
		
}
