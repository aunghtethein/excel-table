package com.ai.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ai.model.Position;
import com.ai.model.Project;
import com.ai.model.Staff;
import com.ai.model.Team;
import com.ai.model.TeamStructure;
import com.ai.repo.PositionRepo;
import com.ai.repo.ProjectRepo;
import com.ai.repo.StaffRepo;
import com.ai.repo.TeamRepo;
import com.ai.util.ExcelUtil;

@Service
public class FileService {
	
	@Autowired
	private PositionRepo positionRepo;
	@Autowired
	private ProjectRepo projectRepo;
	@Autowired
	private StaffRepo staffRepo;
	@Autowired
	private TeamRepo teamRepo;
	
	//Store File Data to database
	public void store(MultipartFile file) throws IOException {
		try {
			List<TeamStructure> list = ExcelUtil.parseExcelFile(file.getInputStream());
			
			for(TeamStructure ts : list) {
				
				Project project = new Project();
				project.setId(ts.getNo());
				project.setName(ts.getProjectName());
				project.setProjectId(ts.getProject());
				projectRepo.save(project);
				
				Team team = new Team();
				team.setId(ts.getNo());
				team.setName(ts.getTeam());
				teamRepo.save(team);

				Position position = new Position();
				position.setId(ts.getNo());
				position.setName(ts.getPosition());
				positionRepo.save(position);
				
				Set<Team> set = new HashSet<>();
				set.add(team);
				
				Set<Project> pjSet = new HashSet<>();
				pjSet.add(project);
				
				Staff staff = new Staff();
				staff.setId(ts.getNo());
				staff.setName(ts.getName());
				staff.setStaffId(ts.getStaffId());
				staff.setTeams(set);
				staff.setProjects(pjSet);
				staff.setPosition(position);
				staffRepo.save(staff);
				
			}
			
			
		}catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

}
