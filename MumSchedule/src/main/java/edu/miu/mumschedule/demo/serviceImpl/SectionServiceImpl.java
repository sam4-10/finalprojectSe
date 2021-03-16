package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.SectionDao;
import edu.miu.mumschedule.demo.domain.Section;
import edu.miu.mumschedule.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SectionServiceImpl implements SectionService {
	private SectionDao sectionDao;

	@Autowired
	public SectionServiceImpl(SectionDao sectionDao) {
		super();
		this.sectionDao = sectionDao;
	}

	@Override
	public List<Section> findAll() {
		return sectionDao.findAll();
	}

	@Override
	public Section findById(int theId) {
		Optional<Section> result = sectionDao.findById(theId);

		Section section = null;

		if (result.isPresent()) {
			section = result.get();
		} else {
			// we didn't find the section
			throw new RuntimeException("Did not find section id - " + theId);
		}

		return section;
	}

	@Override
	public void save(Section section) {
		sectionDao.save(section);

	}

	@Override
	public void deleteById(int theId) {
		sectionDao.deleteById(theId);

	}

}
