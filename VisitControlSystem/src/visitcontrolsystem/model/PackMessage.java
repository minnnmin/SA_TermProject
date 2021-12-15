package visitcontrolsystem.model;

public class PackMessage {
	
	public PackMessage(Object obj, String content) {
    	this.obj = obj;
    	this.content = content;
    }
	private Object obj;
	private String content;
	
	public void printPackMessage() {
		if (obj.getClass() == Visitor.class) {			
//			System.out.println("visitcontrolsystem.model.Visitor : " + ((visitcontrolsystem.model.Visitor)obj).getVid() + "Content :" + this.content);
			Visitor visitor = (Visitor)obj;
			StringBuilder sb = new StringBuilder();
			sb.append("[코로나 확진판별 검사 안내]\n");
			sb.append(visitor.getVname() + "님 역학조사 결과 코로나 확진자와 접촉한 것으로 확인되었습니다.\n");
			sb.append("인근 선별진료소를 통해 확진여부를 검사해주시길 바랍니다.\n");
			System.out.println(sb.toString());
		}
		else if (obj.getClass() == Facility.class) {
//			System.out.println("visitcontrolsystem.model.Facility : " + ((visitcontrolsystem.model.Facility)obj).getFid() + "Content :" + this.content);
			Facility visitor = (Facility)obj;
			StringBuilder sb = new StringBuilder();
			sb.append("[코로나 확진판별 검사 안내]\n");
			sb.append("\"" + visitor.getFname() + "\"" + "관리자님 역학조사 결과 코로나 확진자가 해당 시설에 방문한 것으로 확인되었습니다.\n");
			sb.append("방역이 완료될 때까지 임시휴업 조치 부탁드리며, 관리자님 또한 인근 선별진료소를 통해 확진여부를 검사해주시길 바랍니다.\n");
			System.out.println(sb.toString());
		}
		else {
			System.out.println("error");
		}		
	}
}
