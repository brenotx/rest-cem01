package br.com.cem01.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.cem01.model.TeacherModel;

@Entity
@Table(name="discipline")
public class DisciplineModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code", unique=true)
	private String code;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="disciplineTeacher",
			joinColumns=@JoinColumn(name="disciplineCode", referencedColumnName="code"),
			inverseJoinColumns=@JoinColumn(name="teacherId", referencedColumnName="id"))
	private List<TeacherModel> teacherList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TeacherModel> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TeacherModel> teacherList) {
		this.teacherList = teacherList;
	}

}
