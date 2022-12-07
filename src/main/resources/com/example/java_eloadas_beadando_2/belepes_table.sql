CREATE TABLE `belepes` (
  `id` int(11) NOT NULL,
  `nezoid` int(11) NOT NULL,
  `meccsid` int(11) NOT NULL,
  `idopont` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `belepes`
  ADD KEY `nezoid` (`nezoid`),
  ADD KEY `meccsid` (`meccsid`);

ALTER TABLE `belepes`
  ADD PRIMARY KEY (`id`);
  
  ALTER TABLE `belepes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
  
  ALTER TABLE `belepes`
  ADD CONSTRAINT `belepes_ibfk_1` FOREIGN KEY (`nezoid`) REFERENCES `nezo` (`id`),
  ADD CONSTRAINT `belepes_ibfk_2` FOREIGN KEY (`meccsid`) REFERENCES `meccs` (`id`);