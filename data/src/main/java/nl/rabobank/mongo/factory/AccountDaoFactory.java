package nl.rabobank.mongo.factory;import nl.rabobank.dao.AccountDAO;import nl.rabobank.enums.AccountType;public interface AccountDaoFactory extends AccountDAO {    AccountType getType();}