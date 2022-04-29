\version "2.22.1"

global = {
  \key c \major
  \time 4/4
}

violin = \relative c' {
  \global
  d1 e f g a g f e d  
}

\score {
  \new Staff \with {
    midiInstrument = "violin"
  } \violin
  \layout { }
  \midi {
    \tempo 4=100
  }
}
