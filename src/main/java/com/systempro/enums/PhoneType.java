package com.systempro.enums;

public enum PhoneType {
	
	//estamos dado codigos ao tipo enumerado
		
	
		HOME(1, "Home"),
	    MOBILE(2, "Mobile"),
	    COMMERCIAL(3, "Commercial");

		private int cod;
		private String descricao;

		// atribui o cod e descrição criados para efetuar o tipo de cliente 
		private PhoneType(int cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;

		}

		public int getCod() {
			return cod;
		}

		public String getDescricao() {
			return descricao;
		}
		
		
		public static PhoneType toEnum(Integer cod) {
			//proteção caso o cod seja nulo retorna nulo também
			if(cod == null) {
				return null;
			}
			//esta percorrendo o tipo cliente , TipoCliente.values são todos os codigos possiveis
			for(PhoneType x: PhoneType.values()) {
				//estamos testando se o cod for igual a x.getCod, retorna um codigo x seja ele possoa
				// fisíca ou jurídica.
				if(cod.equals(x.getCod())) {
					return x;
				}
			}
			throw new IllegalArgumentException("Id inválido: " + cod);
			
		}

}
