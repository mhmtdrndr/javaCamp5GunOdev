package kodlama.io.devs.entity.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import kodlama.io.devs.entity.abstracts.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "programing_languages")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProgramingLanguage implements IEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "programingId")
	private int id;
	
	@Column(name = "programinglanguage")
	private String programingLanguageName;
	
	@OneToMany(mappedBy = "programingLanguage")
	private List<SubTechnology> subTechnologies;
}
