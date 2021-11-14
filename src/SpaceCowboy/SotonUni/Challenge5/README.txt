Spirograph Readme:

What is the best ever library made you might ask? Some may say some basic built in library that
has an efficient, beautiful data-structure involved in it like a HashMap or List. But they are all
wrong. Of course, it is TURTLE.

Now why is Turtle the best library ever made. Well it can do anything. It can draw, it has turtles,
what more can you ask of it??? Even the best language in the world, Python, has it pre-installed
into their library.

Whilst it may not be JApplet or some "fancy" library which allows you to add unnecessary features
like a button or simple UI elements, it does everything I wanted it to be able to do. Just draw
a damn line.


Currently there are three equations used:

  Epicycloid:
  x(t) = (R+r)cos(r/R *t) - a*cos((1+r/R)t)
  x(t) = (R+r)sin(r/R *t) - a*sin((1+r/R)t)

  Hypercloid:
  x(t) = (R-r)cos(r/R*t) + a*cos((1-r/R)t);
  y(t) = (R-r)sin(r/R*t) - a*sin((1-r/R)t);

  Other shape (I couldn't find where I originally got it from so IDK the shape name):
  x(t) = (R+r)cos(t) - (r+a)cos(((R+r)/r)t);
  y(t) = (R+r)sin(t) - (r+a)sin(((R+r)/r)t);

where:
        R -> Size of large circle radius
        r -> Size of small circle radius
        a -> distance away from centre of small circle
        t -> time

It will then do some magic calculations and make some cool shapes. Just mess around with the values
there are some in main which show a cool one by default. There's some values you can change tho some
you probably shouldn't as it may just be super slow.