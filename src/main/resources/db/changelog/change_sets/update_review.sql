insert into public.review (restaurant_id, rating, review)
values  ((select id from public.restaurant where id = 1), 10, 'textReview_1'),
        ((select id from public.restaurant where id = 2), 9, 'textReview_2'),
        ((select id from public.restaurant where id = 3), 7, 'textReview_3'),
        ((select id from public.restaurant where id = 4), 8, 'textReview_4'),
        ((select id from public.restaurant where id = 5), 5, 'textReview_5'),
        ((select id from public.restaurant where id = 6), 9, 'textReview_6'),
        ((select id from public.restaurant where id = 7), 2, 'textReview_7'),
        ((select id from public.restaurant where id = 8), 9, 'textReview_8'),
        ((select id from public.restaurant where id = 9), 10, 'textReview_9'),
        ((select id from public.restaurant where id = 10), 3, 'textReview_10');