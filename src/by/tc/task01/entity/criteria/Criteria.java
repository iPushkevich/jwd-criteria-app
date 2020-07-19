package tc.task01.entity.criteria;

import java.util.*;

public class Criteria {

	private final String groupSearchName;
	private Set<CriteriaNameAndValue> criteria = new HashSet<>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public Set<CriteriaNameAndValue> getCriteria() {
		return criteria;
	}

	public void setCriteria(Set<CriteriaNameAndValue> criteria) {
		this.criteria = criteria;
	}

	public void add(String searchCriteria, Object value) {
		CriteriaNameAndValue cr = new CriteriaNameAndValue(searchCriteria, value);
		criteria.add(cr);
	}

	public static class CriteriaNameAndValue{
		String criteriaName;
		Object criteriaValue;

		public CriteriaNameAndValue(String criteriaName, Object criteriaValue) {
			this.criteriaName = criteriaName;
			this.criteriaValue = criteriaValue;
		}

		public String getCriteriaName() {
			return criteriaName;
		}

		public Object getCriteriaValue() {
			return criteriaValue;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			CriteriaNameAndValue that = (CriteriaNameAndValue) o;
			return Objects.equals(criteriaName, that.criteriaName) &&
					Objects.equals(criteriaValue, that.criteriaValue);
		}

		@Override
		public int hashCode() {
			return Objects.hash(criteriaName, criteriaValue);
		}
	}

}
