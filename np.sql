-- get_constraints_drop 

-- get_permissions_drop 

-- get_view_drop

-- get_schema_drop
drop table if exists subscriptions;
drop table if exists stream_state;
drop table if exists stream_history;
drop table if exists playlist_stream_join;
drop table if exists streams;
drop table if exists playlists;
drop table if exists remote_playlists;
drop table if exists search_history;
drop table if exists users;

-- get_smallpackage_pre_sql 

-- get_schema_create
create table users (
   uid              INT   not null AUTO_INCREMENT,
   username         VARCHAR(128)   not null,
   password         VARCHAR(64) not null,
   constraint pk_users primary key (uid),
   constraint unique_users unique (username)
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;


create table subscriptions (
   uid              INT  not null AUTO_INCREMENT,
   user_id          INT   not null,
   service_id       VARCHAR(64)    not null,
   url              VARCHAR(512) not null,
   name             VARCHAR(512) not null,
   avatar_url       VARCHAR(512) not null,
   subscriber_count VARCHAR(512)   not null,
   description      VARCHAR(512) not null,
   constraint pk_subscriptions primary key (uid),
   constraint unique_subscriptions unique (user_id, service_id, url),
   constraint fk_subscriptions_1 foreign key (user_id) references users(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table streams (
   uid           INT  not null AUTO_INCREMENT,
   user_id       INT   not null,
   service_id    VARCHAR(64)        not null,
   url           VARCHAR(512)     not null,
   title         VARCHAR(512)     not null,
   stream_type   VARCHAR(512)     not null,
   duration      VARCHAR(512)       not null,
   uploader      VARCHAR(512)     not null,
   thumbnail_url VARCHAR(512)     not null,
   constraint pk_streams primary key (uid),
   constraint unique_streams unique (user_id, service_id, url),
   constraint fk_streams_1 foreign key (user_id) references users(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table stream_state (
   uid           INT  not null AUTO_INCREMENT,
   user_id       INT   not null,
   stream_id     INT not null,
   progress_time VARCHAR(512) not null,
   constraint pk_stream_state primary key (uid),
   constraint unique_stream_state unique (user_id, stream_id),
   constraint fk_stream_state_1 foreign key (user_id) references users(uid) on update cascade on delete cascade,
   constraint fk_stream_state_2 foreign key (stream_id) references streams(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table playlists (
   uid           INT  not null AUTO_INCREMENT,
   user_id       INT   not null,
   name          VARCHAR(512) not null,
   thumbnail_url VARCHAR(512) not null,
   constraint pk_playlists primary key (uid),
   constraint unique_playlists unique (user_id, name),
   constraint fk_playlists_1 foreign key (user_id) references users(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table remote_playlists (
   uid           INT  not null AUTO_INCREMENT,
   user_id       INT   not null,
   service_id    VARCHAR(64)     not null,
   name          VARCHAR(512) not null,
   url           VARCHAR(512) not null,
   thumbnail_url VARCHAR(512) not null,
   uploader      VARCHAR(512) not null,
   stream_count  VARCHAR(512)   not null,
   constraint pk_remote_playlists primary key (uid),
   constraint unique_playlists unique (user_id, service_id, url),
   constraint fk_remote_playlists_1 foreign key (user_id) references users(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table playlist_stream_join (
   uid         INT  not null AUTO_INCREMENT,
   user_id     INT   not null,
   playlist_id INT not null,
   stream_id   INT not null,
   join_index  INT not null,
   constraint pk_playlist_stream_join primary key (uid),
   constraint unique_playlist_stream_join unique (user_id, playlist_id, join_index),
   constraint fk_playlist_stream_join_1 foreign key(user_id) references users(uid) on update cascade on delete cascade,
   constraint fk_playlist_stream_join_2 foreign key(playlist_id) references playlists(uid) on update cascade on delete cascade,
   constraint fk_playlist_stream_join_3 foreign key(stream_id) references streams(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table search_history (
   uid           INT  not null AUTO_INCREMENT,
   user_id       INT   not null,
   creation_date VARCHAR(512)   not null,
   service_id    VARCHAR(64)    not null,
   search        VARCHAR(512) not null,
   constraint pk_search_history primary key (uid),
   constraint fk_search_history_1 foreign key (user_id) references users(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

create table stream_history (
   uid          INT  not null AUTO_INCREMENT,
   user_id      INT   not null,
   stream_id    INT not null,
   access_date  VARCHAR(512) not null,
   repeat_count VARCHAR(512) not null,
   constraint pk_stream_history primary key (uid),
   constraint unique_stream_history unique (user_id, stream_id, access_date),
   constraint fk_stream_history_1 foreign key (user_id) references users(uid) on update cascade on delete cascade,
   constraint fk_stream_history_2 foreign key (stream_id) references streams(uid) on update cascade on delete cascade
)   ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

-- get_view_create

-- get_permissions_create

-- get_inserts

-- get_smallpackage_post_sql

-- get_associations_create
