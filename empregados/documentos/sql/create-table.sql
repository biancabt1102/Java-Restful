-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.7-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para empregados
CREATE DATABASE IF NOT EXISTS `empregados` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `empregados`;

-- Copiando estrutura para tabela empregados.ddd_empregado
CREATE TABLE IF NOT EXISTS `ddd_empregado` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) NOT NULL,
  `SALARIO` double NOT NULL DEFAULT 0,
  `DATA_ADMISSAO` date NOT NULL DEFAULT curdate(),
  `DATA_DESLIGAMENTO` date DEFAULT curdate(),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela empregados.ddd_empregado: ~1 rows (aproximadamente)
DELETE FROM `ddd_empregado`;
/*!40000 ALTER TABLE `ddd_empregado` DISABLE KEYS */;
INSERT INTO `ddd_empregado` (`ID`, `NOME`, `SALARIO`, `DATA_ADMISSAO`, `DATA_DESLIGAMENTO`) VALUES
	(1, 'BENEFRANCIS DO NASCIMENTO', 25000, '2008-10-01', NULL);
/*!40000 ALTER TABLE `ddd_empregado` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
