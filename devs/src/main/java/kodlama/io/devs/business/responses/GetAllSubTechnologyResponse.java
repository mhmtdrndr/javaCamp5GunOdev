package kodlama.io.devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSubTechnologyResponse {
	
	private int id;
	private String subTechnologyName;

}
