package com.dataforge.model;

public class DashBordResponse {
	       
	       private Integer total_enq;
	       
	       private Integer enrolled;
	       
	       private Integer lost;
	       
	       public DashBordResponse() {
	    	   
	       }
	       

		public DashBordResponse(Integer total_enq, Integer enrolled, Integer lost) {
			super();
			this.total_enq = total_enq;
			this.enrolled = enrolled;
			this.lost = lost;
		}


		public Integer getTotal_enq() {
			return total_enq;
		}

		public void setTotal_enq(Integer total_enq) {
			this.total_enq = total_enq;
		}

		public Integer getEnrolled() {
			return enrolled;
		}

		public void setEnrolled(Integer enrolled) {
			this.enrolled = enrolled;
		}

		public Integer getLost() {
			return lost;
		}

		public void setLost(Integer lost) {
			this.lost = lost;
		}

		@Override
		public String toString() {
			return "DashBordResponse [total_enq=" + total_enq + ", enrolled=" + enrolled + ", lost=" + lost + "]";
		}

	       
	       
}
