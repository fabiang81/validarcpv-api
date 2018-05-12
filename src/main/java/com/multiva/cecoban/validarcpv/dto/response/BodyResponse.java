package com.multiva.cecoban.validarcpv.dto.response;

public class BodyResponse {
	
	private Response response;
	private TimeStamp timeStamp;
	private Digestivos digestivos;
	private ComparacionCurp comparacionCurp;
	
	private BodyResponse(Builder builder) {
		this.response = builder.response;
		this.timeStamp = builder.timeStamp;
		this.digestivos = builder.digestivos;
		this.comparacionCurp = builder.comparacionCurp;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public TimeStamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(TimeStamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Digestivos getDigestivos() {
		return digestivos;
	}

	public void setDigestivos(Digestivos digestivos) {
		this.digestivos = digestivos;
	}

	public ComparacionCurp getComparacionCurp() {
		return comparacionCurp;
	}

	public void setComparacionCurp(ComparacionCurp comparacionCurp) {
		this.comparacionCurp = comparacionCurp;
	}
	
	@Override
	public String toString() {
		return "BodyResponse [response=" + response + ", timeStamp=" + timeStamp + ", digestivos=" + digestivos
				+ ", comparacionCurp=" + comparacionCurp + "]";
	}

	public static class Builder{
		
		private Response response;
		private TimeStamp timeStamp;
		private Digestivos digestivos;
		private ComparacionCurp comparacionCurp;
		
		public Builder response(Response response) {
			this.response = response;
			return this;
		}
		
		public Builder timeStamp(TimeStamp timeStamp) {
			this.timeStamp = timeStamp;
			return this;
		}
		
		public Builder digestivos(Digestivos digestivos) {
			this.digestivos = digestivos;
			return this;
		}
		
		public Builder comparacionCurp(ComparacionCurp comparacionCurp) {
			this.comparacionCurp = comparacionCurp;
			return this;
		}
		
		public BodyResponse build() {
			return new BodyResponse(this);
		}
		
	}

}
