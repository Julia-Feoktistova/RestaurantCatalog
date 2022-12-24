insert into review (restaurant_id, rating, review)
values  ((select id from restaurant where id = 1), 10, 'textReview_1'),
        ((select id from restaurant where id = 2), 9, 'textReview_2'),
        ((select id from restaurant where id = 3), 7, 'textReview_3'),
        ((select id from restaurant where id = 4), 8, 'textReview_4'),
        ((select id from restaurant where id = 5), 5, 'textReview_5'),
        ((select id from restaurant where id = 6), 9, 'textReview_6'),
        ((select id from restaurant where id = 7), 2, 'textReview_7'),
        ((select id from restaurant where id = 1), 9, 'textReview_11'),
        ((select id from restaurant where id = 1), 10, 'textReview_111'),
        ((select id from restaurant where id = 10), 3, 'textReview_10');