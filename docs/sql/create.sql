CREATE TABLE tracks (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    device VARCHAR(50),
    os VARCHAR(50),
    name VARCHAR(50),
    actions TEXT,
    start_datetime DATETIME DEFAULT NULL,
    end_datetime DATETIME DEFAULT NULL,
    created DATETIME DEFAULT NULL,
    modified DATETIME DEFAULT NULL
);

INSERT INTO tracks (
  device,
  os,
  name,
  actions,
  start_datetime,
  end_datetime
)
VALUES
(  'Android',
   'Android',
   'Custom Phone - 4.1.1 - API 16 - 768x1280',
   '{ "action": { "onShowPress": { "X1": 203.73472595214844, "X2": -1, "Y1": 138.89149475097656, "time2": -1, "Y2": -1, "time1": 19001483, "current-time": "2014-11-1 8:16:44" }, "onFling": { "X1": 643.1625366210938, "X2": 684.1092529296875, "Y1": 229.82044982910156, "time2": 19009019, "Y2": 632.505859375, "time1": 19008723, "current-time": "2014-11-1 8:16:51" }, "onDown": { "X1": 643.1625366210938, "X2": -1, "Y1": 229.82044982910156, "time2": -1, "Y2": -1, "time1": 19008723, "current-time": "2014-11-1 8:16:51" }, "onScroll": { "X1": 643.1625366210938, "X2": 684.1092529296875, "Y1": 229.82044982910156, "time2": 19009007, "Y2": 631.9000854492188, "time1": 19008723, "current-time": "2014-11-1 8:16:51" } }, "device": "Android", "os": "Android", "date": "2014-11-1 8:16:13", "name": "Custom Phone - 4.1.1 - API 16 - 768x1280" }',
   '2014/11/1 8:16:13',
   '2014/11/1 8:16:44'
);