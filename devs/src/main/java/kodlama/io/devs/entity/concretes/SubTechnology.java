package kodlama.io.devs.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kodlama.io.devs.entity.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "sub_technologies")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubTechnology implements IEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subTechnologyId")
	private int id;
	
	@Column(name = "subtechnologyname")
	private String subTechnologyName;
	
	@ManyToOne
	@JoinColumn(name = "programingId")
	private ProgramingLanguage programingLanguage;

}
