-- Active: 1720677359157@@aloha-qr-db.ctm4c4acm90g.ap-northeast-2.rds.amazonaws.com@3306@aloha
DROP TABLE IF EXISTS `checks`;
CREATE TABLE `checks` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    attendance_date DATE NOT NULL,
    status ENUM('출석', '결석', '지각', '조퇴') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 📄
INSERT INTO checks (name, attendance_date, status) VALUES 
('조연진', '2023-07-10', '출석'),
('김유정', '2023-07-10', '결석'),
('김슬기', '2023-07-10', '지각'),
('신준수', '2023-07-10', '조퇴'),
('정다운', '2023-07-10', '출석');
